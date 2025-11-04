package PipelinesInTeamCity_DockerIntegrations

import PipelinesInTeamCity_DockerIntegrations.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project
import jetbrains.buildServer.configs.kotlin.projectFeatures.dockerECRRegistry
import jetbrains.buildServer.configs.kotlin.projectFeatures.dockerRegistry
import jetbrains.buildServer.configs.kotlin.projectFeatures.npmRegistry

object Project : Project({

    vcsRoot(PipelinesInTeamCity_DockerIntegrations_AntProjectMain)
    vcsRoot(PipelinesInTeamCity_DockerIntegrations_MicrosoftNUnitCTestsProjectMain)
    vcsRoot(PipelinesInTeamCity_DockerIntegrations_AntProject1main)
    vcsRoot(PipelinesInTeamCity_DockerIntegrations_NewPipelineAzureFunctionsVsBuildSdkMain)
    vcsRoot(PipelinesInTeamCity_DockerIntegrations_BookingApiPayconiqMain)
    vcsRoot(PipelinesInTeamCity_DockerIntegrations_CommandLineImageFromTheGhcrMain)
    vcsRoot(PipelinesInTeamCity_DockerIntegrations_TestingJavascriptNpmMain)
    vcsRoot(PipelinesInTeamCity_DockerIntegrations_NetNUnitCTestsMain)
    vcsRoot(PipelinesInTeamCity_DockerIntegrations_NunitCsharpTestsProjectGlConnectionMain)
    vcsRoot(PipelinesInTeamCity_DockerIntegrations_HttpsGithubComDariaKrupBookingApiPayconiqMaster)
    vcsRoot(PipelinesInTeamCity_DockerIntegrations_EcrJavaMavenJUnitMain)
    vcsRoot(PipelinesInTeamCity_DockerIntegrations_HttpsGithubComDariaKrupCommandLineRunnerRefsHeadsMaster)
    vcsRoot(PipelinesInTeamCity_DockerIntegrations_RingUiMain)

    params {
        password("docker_password", "credentialsJSON:82cbcea7-18a1-4a18-9e08-c383d88d5f4f")
    }

    features {
        dockerRegistry {
            id = "PROJECT_EXT_558"
            name = "Docker Registry (parent project)"
            userName = "dariakrup"
            password = "credentialsJSON:82cbcea7-18a1-4a18-9e08-c383d88d5f4f"
        }
        dockerECRRegistry {
            id = "PROJECT_EXT_559"
            displayName = "Amazon ECR (parent project)"
            ecrType = ecrPrivate()
            registryId = "913206223978"
            credentialsProvider = accessKey {
                accessKeyId = "AKIA5JH2VERVI62P5XDY"
                secretAccessKey = "credentialsJSON:5956c87f-9f8f-4ec4-8c89-2874bed09e35"
            }
            regionCode = "eu-west-1"
            credentialsType = accessKeys()
        }
        dockerRegistry {
            id = "PROJECT_EXT_560"
            name = "GitHub Registry (JetBrains)"
            url = "https://ghcr.io"
            userName = "DariaKrup"
            password = "credentialsJSON:20d23358-cc75-492f-9dfe-56501647191f"
        }
        npmRegistry {
            id = "PROJECT_EXT_620"
            name = "NPM Registry (local)"
            scope = ""
            token = "credentialsJSON:4d8e75ba-508e-4c1d-847f-37db9a1a2661"
        }
    }

    subProject(PipelinesInTeamCity_DockerIntegrations_PipelineIntegrations.Project)
})
