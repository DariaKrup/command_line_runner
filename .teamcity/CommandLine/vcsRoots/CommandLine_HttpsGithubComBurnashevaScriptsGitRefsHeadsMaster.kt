package CommandLine.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

object CommandLine_HttpsGithubComBurnashevaScriptsGitRefsHeadsMaster : GitVcsRoot({
    uuid = "8c9f589e-c9b1-4b74-9dff-4ee2db24e7d6"
    name = "https://github.com/burnasheva/scripts.git#refs/heads/master"
    url = "https://github.com/burnasheva/scripts.git"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/*"
    param("useAlternates", "true")
})
