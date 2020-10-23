package CommandLine.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

object CommandLine_GitCloneInCommandLine : BuildType({
    uuid = "aacf2adf-6fb3-4bd1-a4ec-1dc2ddb801b4"
    name = "git clone in command line"
    paused = true

    vcs {
        cleanCheckout = true
    }

    steps {
        script {
            scriptContent = """
                git clone https://github.com/Microsoft/msbuild.git
                ls msbuild
            """.trimIndent()
            param("teamcity.runAs.windowsIntegrityLlevel", "auto")
            param("teamcity.runAs.loggingLevel", "off")
        }
    }

    failureConditions {
        errorMessage = true
    }
})
