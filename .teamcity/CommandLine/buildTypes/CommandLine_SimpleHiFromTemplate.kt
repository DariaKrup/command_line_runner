package CommandLine.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs

object CommandLine_SimpleHiFromTemplate : BuildType({
    templates(AbsoluteId("ManualTemplate_2"))
    uuid = "0ca980e5-0c92-41c9-83c9-800d52aa7a28"
    name = "simple hi from template"
    paused = true

    params {
        param("some.property", """
            some.value.1.2.3
            multi.line.2.2
            new.line
        """.trimIndent())
    }

    triggers {
        vcs {
            id = "vcsTrigger"
            triggerRules = "+:root=DotnetCore30:**.java"

        }
    }
})
