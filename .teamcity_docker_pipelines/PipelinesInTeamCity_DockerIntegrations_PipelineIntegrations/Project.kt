package PipelinesInTeamCity_DockerIntegrations_PipelineIntegrations

import PipelinesInTeamCity_DockerIntegrations_PipelineIntegrations.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project

object Project : Project({
    id("PipelineIntegrations")
    name = "Pipeline Integrations"

    vcsRoot(PipelinesInTeamCity_DockerIntegrations_PipelineIntegrations_EcrPrivateAntProjectMain)
    vcsRoot(PipelinesInTeamCity_DockerIntegrations_PipelineIntegrations_EcrBookingApiPayconiqMain)
    vcsRoot(PipelinesInTeamCity_DockerIntegrations_PipelineIntegrations_GcrPublicAzureFunctionsVsSdkMain)
    vcsRoot(PipelinesInTeamCity_DockerIntegrations_PipelineIntegrations_RedHatPublicBookingApiPayconiqMain)
    vcsRoot(PipelinesInTeamCity_DockerIntegrations_PipelineIntegrations_BookingApiPayconiqAutoCompleteMain)
})
