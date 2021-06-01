package CommandLine.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.exec

object CommandLine_RunScriptFromProgramFiles : BuildType({
    uuid = "104cfbbe-eeae-48ce-8550-f987e492f01c"
    name = "run script from program files"

    params {
        param("mercurialPath", """C:\Program Files\Mercurial""")
    }

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
