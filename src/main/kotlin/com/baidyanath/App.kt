package com.baidyanath

import com.baidyanath.common.AppHealthCheck
import com.baidyanath.config.db.DBConfig
import com.baidyanath.config.resource.ResourceConfig
import io.dropwizard.Application
import io.dropwizard.configuration.EnvironmentVariableSubstitutor
import io.dropwizard.configuration.SubstitutingSourceProvider
import io.dropwizard.db.DataSourceFactory
import io.dropwizard.jdbi3.JdbiFactory
import io.dropwizard.migrations.MigrationsBundle
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import io.federecio.dropwizard.swagger.SwaggerBundle
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration


fun main(args: Array<String>) {
    App().run(*args)
}

class App : Application<AppConfig>() {

    override fun run(configuration: AppConfig, environment: Environment) {

        // Initialize DB connection
        DBConfig.initialize(
            appConfig = configuration,
            environment = environment,
            jdbi = JdbiFactory().build(environment, configuration.database, "mysql")
        )

        // Register all resource files
        ResourceConfig(environment).register()

        // register health checks
        environment.healthChecks().register("Health Check", AppHealthCheck("drievrs"))
    }

    override fun initialize(bootstrap: Bootstrap<AppConfig>) {
        bootstrap.configurationSourceProvider = SubstitutingSourceProvider(
            bootstrap.configurationSourceProvider, EnvironmentVariableSubstitutor(false)
        )

        bootstrap.addBundle(
            object : MigrationsBundle<AppConfig>() {
                override fun getDataSourceFactory(configuration: AppConfig): DataSourceFactory {
                    return configuration.database
                }
            }
        )

        bootstrap.addBundle(
            object : SwaggerBundle<AppConfig>() {
                override fun getSwaggerBundleConfiguration(configuration: AppConfig): SwaggerBundleConfiguration {
                    return configuration.swaggerBundleConfiguration
                }
            }
        )
    }
}