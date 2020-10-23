package CommandLine.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

object CommandLine_ListHiddenDirectory : BuildType({
    uuid = "60e64149-e771-4d17-a19d-c1e81fc4de9b"
    name = "list hidden directory"
    paused = true

    steps {
        script {
            scriptContent = "cat ../../conf/default.properties"
        }
    }

    requirements {
        doesNotContain("teamcity.agent.jvm.os.name", "Windows")
    }
})
