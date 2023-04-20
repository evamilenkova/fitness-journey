package com.sorsix.fitnessjourney.util
import com.sorsix.fitnessjourney.model.Exercise
import com.sorsix.fitnessjourney.model.Muscle
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClientBuilder
import java.io.BufferedReader
import java.io.InputStreamReader
import com.sorsix.fitnessjourney.repository.ExerciseRepository
import com.sorsix.fitnessjourney.repository.MuscleRepository
import org.json.JSONArray
import java.net.URLEncoder

import java.util.*

fun fetchExercisesFromRapidApi(muscleRepository: MuscleRepository, exerciseRepository: ExerciseRepository) {
    muscleRepository.findAll().forEach { muscle ->
        val encodedMuscleName = URLEncoder.encode(muscle.name, "UTF-8")
        //val url = "https://musclewiki.p.rapidapi.com/exercises?muscle=" + muscle.name
        val url = "https://musclewiki.p.rapidapi.com/exercises?muscle=$encodedMuscleName"
        val httpClient: HttpClient = HttpClientBuilder.create().build() //za get request
        val httpGet = HttpGet(url)
        httpGet.setHeader("X-RapidAPI-Key", "b369fd5f1fmsha4c1e0421129ce8p1ce290jsn5dffc31bfccb")
        httpGet.setHeader("X-RapidAPI-Host", "musclewiki.p.rapidapi.com")
        httpGet.setHeader("Content-Type", "application/json") //dodadeno za da gi dava vo json
        val response = httpClient.execute(httpGet)
        val bufferedReader = BufferedReader(InputStreamReader(response.entity.content))
        val stringBuilder = StringBuilder()
        var line: String? = ""
        while (bufferedReader.readLine().also { line = it } != null) {
            stringBuilder.append(line)
        }
        bufferedReader.close()

        // Parse JSON response
        val responseBody = stringBuilder.toString()
        val jsonArray = JSONArray(responseBody) //from string to json

        // Print the fetched data
//        println("Fetched data from Rapid API:")
//        println("Response body: $responseBody") // Print the response body as a string
        for (i in 0 until jsonArray.length()) {
            val exerciseObj = jsonArray.getJSONObject(i)

            var name = "";
            if (exerciseObj.has("exercise_name")) {
                name = exerciseObj.getString("exercise_name")
            }

            var category = "";
            if (exerciseObj.has("Category")) {
                category = exerciseObj.getString("Category")
            }

            var force = "";
            if (exerciseObj.has("Force")) {
                force = exerciseObj.getString("Force")
            }

            var steps = emptyArray<String>();
            if (exerciseObj.has("steps")) {
                val jsonArray = exerciseObj.getJSONArray("steps")
                steps = Array(jsonArray.length()) { j ->
                    jsonArray.getString(j).toString().take(255)
                }
            }

            var video = emptyArray<String>();
            if (exerciseObj.has("videoURL")) {
                val jsonArray = exerciseObj.getJSONArray("videoURL")
                video = Array(jsonArray.length()) { j ->
                    jsonArray.getString(j).toString().take(255)
                }
            }

//            println("NAME")
//            println(name)
//            println("CATEGORY")
//            println(category)
//            println("FORCE")
//            println(force)
//            println("STEPS")
//            println(steps)
//            println("VIDEO")
//            println(video)

            // Create exerciseEntity object and save to exerciseRepository
            val muscle = muscleRepository.findByName("Biceps")
            val exerciseEntity = Exercise(name = name, category = category,
                force = force, steps = steps, videos = video, muscle = muscle
            );
            exerciseRepository.save(exerciseEntity)
        }
    }
}