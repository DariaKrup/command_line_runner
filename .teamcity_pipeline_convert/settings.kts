import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.pipelines.*
import jetbrains.buildServer.configs.kotlin.projectFeatures.dockerRegistry
import jetbrains.buildServer.configs.kotlin.triggers.vcs
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2025.11"

project {

    vcsRoot(HttpsGithubComDariaKrupBookingApiPayconiqRefsHeadsMaster)

    features {
        dockerRegistry {
            id = "PROJECT_EXT_944"
            name = "Docker Registry (parent)"
            userName = "dariakrup"
            password = "credentialsJSON:82cbcea7-18a1-4a18-9e08-c383d88d5f4f"
        }
    }

    pipeline(CommandLineRunnerPipeline)
}

object HttpsGithubComDariaKrupBookingApiPayconiqRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/DariaKrup/BookingApiPayconiq#refs/heads/master"
    url = "https://github.com/DariaKrup/BookingApiPayconiq"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/*"
    authMethod = token {
        userName = "oauth2"
        tokenId = "tc_token_id:CID_4b4df26346ed38498f51c0d6bee05baa:-1:1f8a779b-208d-41e1-a767-f85f656bdcec"
    }
    param("pipelines.connectionId", "PROJECT_EXT_130")
    param("tokenType", "refreshable")
})


object CommandLineRunnerPipeline : Pipeline({
    name = "Command Line Runner: pipeline"

    repositories {
        repository(DslContext.settingsRoot)
    }

    params {
        password("password", "credentialsJSON:45fad3a0-0530-4023-bfdd-e7b613048c84")
    }

    triggers {
        vcs {
            branchFilter = """
                -pr:*
                +:*
            """.trimIndent()
        }
    }

    integrations {
        dockerRegistry {
            id = "Docker_0"
            name = "Docker"
            userName = "d"
            password = "d"
        }
    }

    job(CommandLineRunnerPipeline_Job1)
})

object CommandLineRunnerPipeline_Job1 : Job({
    id("Job1")
    name = "Job: CMD"
    allowReuse = false
    enableDependencyCacheOptimization = false

    integration("Docker", "PROJECT_EXT_937")
    integration("Docker", "PROJECT_EXT_944")
    integration("Docker", "Docker_0")

    steps {
        script {
            name = "Sh script"
            scriptContent = "sh ./echo.sh"
        }
        script {
            name = "Password"
            scriptContent = "echo %password% >> pass.txt"
        }
    }

    outputFiles {
        pipelineArtifacts("./pass.txt")
    }
})
