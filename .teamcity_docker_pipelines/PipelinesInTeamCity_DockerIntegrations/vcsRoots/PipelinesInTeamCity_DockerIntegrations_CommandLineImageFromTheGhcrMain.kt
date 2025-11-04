package PipelinesInTeamCity_DockerIntegrations.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object PipelinesInTeamCity_DockerIntegrations_CommandLineImageFromTheGhcrMain : GitVcsRoot({
    id("CommandLineImageFromTheGhcrMain")
    name = "Command Line: image from the GHCR: main"
    url = "https://github.com/DariaKrup/command_line_runner"
    branch = "master"
    branchSpec = "refs/heads/*"
    authMethod = password {
        userName = "DariaKrup"
        password = "credentialsJSON:a9f10039-e193-4665-afab-91b5b38ce930"
    }
    param("pipelines.connectionId", "PROJECT_EXT_238")
})
