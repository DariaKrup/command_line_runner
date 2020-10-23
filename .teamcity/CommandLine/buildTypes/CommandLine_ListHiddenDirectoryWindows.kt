package CommandLine.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

object CommandLine_ListHiddenDirectoryWindows : BuildType({
    uuid = "80b31753-b1a7-4670-927a-28ccd0070952"
    name = "list hidden directory (windows)"
    paused = true

    steps {
        script {
            scriptContent = """type ..\..\conf\runas\default.properties"""
        }
    }

    requirements {
        contains("teamcity.agent.jvm.os.name", "Windows")
    }
})
