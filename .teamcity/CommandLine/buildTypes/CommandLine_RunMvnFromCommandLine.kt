package CommandLine.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

object CommandLine_RunMvnFromCommandLine : BuildType({
    uuid = "0a143cb8-31dc-43c3-ae54-01997cb43253"
    name = "run mvn from command line"
    paused = true

    vcs {
        root(AbsoluteId("HttpsGithubComBurnashevaMvn2springOpenjpaGitRefsHeadsMaster"))
    }

    steps {
        script {
            scriptContent = "mvn clean test"
            formatStderrAsError = true
            param("teamcity.runAs.windowsIntegrityLlevel", "auto")
            param("teamcity.runAs.loggingLevel", "off")
        }
    }
})
