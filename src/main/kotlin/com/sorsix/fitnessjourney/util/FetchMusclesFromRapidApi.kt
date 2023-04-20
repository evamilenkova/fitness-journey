import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClientBuilder
import java.io.BufferedReader
import java.io.InputStreamReader
import com.sorsix.fitnessjourney.model.Muscle
import com.sorsix.fitnessjourney.repository.MuscleRepository

import org.json.JSONObject
import java.util.*

fun fetchMusclesFromRapidApi(muscleRepository: MuscleRepository) {
    val url = "https://musclewiki.p.rapidapi.com/exercises/attributes"
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
    val jsonObject = JSONObject(responseBody) //from string to json

    // Print the fetched data
    println("Fetched data from Rapid API:")
    println("Response body: $responseBody") // Print the response body as a string
    val musclesArray = jsonObject.getJSONArray("muscles")
    //za sekoj element od array se povikuva konstruktorot od Muscle entitetot i se zacuvuva vo repository
    musclesArray.forEach { muscle ->
        val muscleEntity = Muscle(name = muscle.toString()) // Create Muscle entity
        muscleRepository.save(muscleEntity) // Save Muscle entity to the database
        println(muscle.toString())
    }
}