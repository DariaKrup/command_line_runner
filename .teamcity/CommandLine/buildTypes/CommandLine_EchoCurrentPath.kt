package CommandLine.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

object CommandLine_EchoCurrentPath : BuildType({
    uuid = "2dbaaca0-cacd-4a07-ae00-fab6ee03f12f"
    name = "Echo current path"

    steps {
        script {
            scriptContent = """
                for /f %%%%i in ('cd') do set path=%%%%i
                echo "current path: %%path%%"
            """.trimIndent()
            param("org.jfrog.artifactory.selectedDeployableServer.downloadSpecSource", "Job configuration")
            param("org.jfrog.artifactory.selectedDeployableServer.useSpecs", "false")
            param("org.jfrog.artifactory.selectedDeployableServer.uploadSpecSource", "Job configuration")
        }
    }
})
