package CommandLine.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.exec

object CommandLine_RunScriptFromWorkingDirectoryCustomScript : BuildType({
    uuid = "67b8d113-4768-48bf-bf94-4a7b281b1a4c"
    name = "run script from working directory (custom script)"

    vcs {
        root(CommandLine.vcsRoots.CommandLine_HttpsGithubComBurnashevaScriptsGitRefsHeadsMaster)
    }

    steps {
        exec {
            workingDir = "subdirectory"
            path = "subdirectory/hello_world.sh"
        }
    }
})
