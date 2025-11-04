package PipelinesInTeamCity_DockerIntegrations.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object PipelinesInTeamCity_DockerIntegrations_TestingJavascriptNpmMain : GitVcsRoot({
    id("TestingJavascriptNpmMain")
    name = "Testing Javascript: NPM: main"
    url = "https://github.com/DariaKrup/testing-javascript.git"
    branch = "master"
    branchSpec = "refs/heads/*"
})
