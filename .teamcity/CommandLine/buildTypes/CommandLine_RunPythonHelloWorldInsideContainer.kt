package CommandLine.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

object CommandLine_RunPythonHelloWorldInsideContainer : BuildType({
    uuid = "98a875e7-5783-4fd2-8c9c-fefb14a71608"
    name = "run python hello world inside container"
    paused = true

    vcs {
        root(AbsoluteId("HttpsGithubComBurnashevaMvn2springOpenjpaGitRefsHeadsMaster"))

        checkoutDir = "git_resources"
    }

    steps {
        script {
            scriptContent = """
                #!/usr/bin/python
                print("Hello, world")
            """.trimIndent()
            dockerRunParameters = "--rm"
            param("teamcity.runAs.windowsIntegrityLlevel", "auto")
            param("teamcity.runAs.loggingLevel", "off")
        }
    }

    requirements {
        doesNotContain("teamcity.agent.jvm.os.name", "Windows")
    }
})
