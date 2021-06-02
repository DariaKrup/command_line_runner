package CommandLine.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

object CommandLine_RunScriptFromWorkingDirectoryCustomScript : BuildType({
    uuid = "67b8d113-4768-48bf-bf94-4a7b281b1a4c"
    name = "run script from working directory (custom script)"

    vcs {
        root(CommandLine.vcsRoots.CommandLine_HttpsGithubComBurnashevaScriptsGitRefsHeadsMaster)
    }

    steps {
        script {
            scriptContent = "subdirectory/hello_world.sh"
            param("org.jfrog.artifactory.selectedDeployableServer.downloadSpecSource", "Job configuration")
            param("org.jfrog.artifactory.selectedDeployableServer.useSpecs", "false")
            param("org.jfrog.artifactory.selectedDeployableServer.uploadSpecSource", "Job configuration")
        }
    }
})
