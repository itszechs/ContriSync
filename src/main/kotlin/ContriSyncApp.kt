package zechs.contri.sync

import com.apollographql.apollo3.ApolloClient

class ContriSyncApp {

    suspend operator fun invoke(username: String, token: String) {
        val client = ApolloClient.Builder()
            .serverUrl("https://api.github.com/graphql")
            .addHttpHeader("Authorization", "Bearer $token")
            .build()
        client.use {
            val contributions = client.query(ContributionCalendarQuery(username))
                    .execute().dataAssertNoErrors
            println(contributions)
        }
    }

}