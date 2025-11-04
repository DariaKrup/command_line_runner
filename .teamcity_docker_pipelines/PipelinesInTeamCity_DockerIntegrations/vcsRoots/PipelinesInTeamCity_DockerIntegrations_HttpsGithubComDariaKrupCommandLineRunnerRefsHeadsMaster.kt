package PipelinesInTeamCity_DockerIntegrations.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object PipelinesInTeamCity_DockerIntegrations_HttpsGithubComDariaKrupCommandLineRunnerRefsHeadsMaster : GitVcsRoot({
    id("HttpsGithubComDariaKrupCommandLineRunnerRefsHeadsMaster")
    name = "https://github.com/DariaKrup/command_line_runner#refs/heads/master"
    url = "https://github.com/DariaKrup/command_line_runner"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/*"
    authMethod = password {
        userName = "DariaKrup"
        password = "credentialsJSON:8b7b8fc3-ca87-451b-9fda-64460a6201e6"
    }
    param("pipelines.connectionId", "PROJECT_EXT_571")
})
