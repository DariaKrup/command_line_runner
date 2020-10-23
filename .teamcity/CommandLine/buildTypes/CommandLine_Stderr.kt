package CommandLine.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

object CommandLine_Stderr : BuildType({
    uuid = "cfa2568c-2dbc-45a7-a6ce-ca78401503a4"
    name = "stderr"
    paused = true

    steps {
        script {
            scriptContent = """
                >&2 echo "error"
                >&2 echo "error"
                >&2 echo "error"
                >&2 echo "error"
                >&2 ls -la
            """.trimIndent()
            formatStderrAsError = true
            dockerImage = "ubuntu"
            param("teamcity.runAs.windowsIntegrityLlevel", "auto")
            param("teamcity.runAs.loggingLevel", "off")
        }
    }
})
