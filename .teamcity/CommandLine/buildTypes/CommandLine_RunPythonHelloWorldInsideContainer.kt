package CommandLine.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

object CommandLine_RunPythonHelloWorldInsideContainer : BuildType({
    uuid = "98a875e7-5783-4fd2-8c9c-fefb14a71608"
    name = "run python hello world inside container"
    paused = true

    vcs {
        root(AbsoluteId("HttpsGithubComBurnashevaMvn2springOpenjpaGitRefsHeadsMaster_3"))

        checkoutDir = "git_resources"
    }

    steps {
        script {
            scriptContent = """
                #!/usr/bin/python3
                print("Hello, world")
            """.trimIndent()
            dockerRunParameters = "--rm"
            param("org.jfrog.artifactory.selectedDeployableServer.downloadSpecSource", "Job configuration")
            param("org.jfrog.artifactory.selectedDeployableServer.useSpecs", "false")
            param("org.jfrog.artifactory.selectedDeployableServer.uploadSpecSource", "Job configuration")
        }
    }

    requirements {
        doesNotContain("teamcity.agent.jvm.os.name", "Windows")
    }
})
