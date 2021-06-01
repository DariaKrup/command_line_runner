package CommandLine.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

object CommandLine_HttpsGithubComBurnashevaMavenUnbalancedMessagesGitRefsHeadsMaster : GitVcsRoot({
    uuid = "31d9aa84-40e8-44c8-8de9-3383b724f64a"
    name = "https://github.com/burnasheva/maven_unbalanced_messages.git#refs/heads/master"
    url = "https://github.com/burnasheva/maven_unbalanced_messages.git"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/*"
    param("useAlternates", "true")
})
