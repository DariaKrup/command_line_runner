package PipelinesInTeamCity_DockerIntegrations_PipelineIntegrations.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object PipelinesInTeamCity_DockerIntegrations_PipelineIntegrations_EcrBookingApiPayconiqMain : GitVcsRoot({
    id("PipelineIntegrations_EcrBookingApiPayconiqMain")
    name = "ECR: BookingApiPayconiq: main"
    url = "https://github.com/DariaKrup/BookingApiPayconiq"
    branch = "master"
    branchSpec = "refs/heads/*"
    authMethod = password {
        userName = "DariaKrup"
        password = "credentialsJSON:a9f10039-e193-4665-afab-91b5b38ce930"
    }
    param("pipelines.connectionId", "PROJECT_EXT_238")
})
