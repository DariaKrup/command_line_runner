package CommandLine.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

object CommandLine_LsContentOfTheHomeDirectory : BuildType({
    uuid = "b15d5ba7-e0b4-4026-ab31-f2de7853fa8c"
    name = "ls content of the home directory"

    steps {
        script {
            scriptContent = "ls -la ~"
            param("org.jfrog.artifactory.selectedDeployableServer.downloadSpecSource", "Job configuration")
            param("org.jfrog.artifactory.selectedDeployableServer.useSpecs", "false")
            param("org.jfrog.artifactory.selectedDeployableServer.uploadSpecSource", "Job configuration")
        }
    }
})
