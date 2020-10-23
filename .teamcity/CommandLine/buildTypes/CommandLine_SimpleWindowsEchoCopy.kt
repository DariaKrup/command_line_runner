package CommandLine.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*

object CommandLine_SimpleWindowsEchoCopy : BuildType({
    templates(CommandLine_SimpleTemplate)
    uuid = "1f9d5196-8ce2-42e1-9571-737b0d611baf"
    name = "Simple Windows Echo (Copy)"
    paused = true

    params {
        param("some.property", """
            some.value.1.2.3
            multi.line.2.2
            new.line
        """.trimIndent())
    }
})
