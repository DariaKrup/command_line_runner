package CommandLine.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.exec

object CommandLine_RunScriptFromWorkingDirectory : BuildType({
    uuid = "36e73e99-655c-4ca0-ab0a-0c62035ca18b"
    name = "run script from working directory"

    vcs {
        root(CommandLine.vcsRoots.CommandLine_HttpsGithubComBurnashevaScriptsGitRefsHeadsMaster)
    }

    steps {
        exec {
            workingDir = "subdirectory"
            path = "hello_world.sh"
        }
    }
})
