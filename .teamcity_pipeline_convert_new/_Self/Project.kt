package _Self

import _Self.vcsRoots.*
import _Self.pipelines.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project
import jetbrains.buildServer.configs.kotlin.projectFeatures.dockerRegistry

object Project : Project({

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
})
