package PipelinesInTeamCity_DockerIntegrations.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object PipelinesInTeamCity_DockerIntegrations_RingUiMain : GitVcsRoot({
    id("RingUiMain")
    name = "Ring Ui: main"
    url = "https://github.com/JetBrains/ring-ui.git"
    branch = "master"
    branchSpec = "refs/heads/*"
})
