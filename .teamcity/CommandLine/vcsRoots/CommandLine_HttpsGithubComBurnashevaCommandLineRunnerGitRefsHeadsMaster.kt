package CommandLine.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

object CommandLine_HttpsGithubComBurnashevaCommandLineRunnerGitRefsHeadsMaster : GitVcsRoot({
    uuid = "bebbbcd3-ad10-4962-a0ce-879c26f93b1a"
    name = "https://github.com/burnasheva/command_line_runner.git#refs/heads/master"
    url = "https://github.com/burnasheva/command_line_runner.git"
    branch = "refs/heads/master"
    authMethod = password {
        userName = "burnasheva"
        password = "credentialsJSON:f582ecb0-3de3-44c1-bf46-161576de70be"
    }
})
