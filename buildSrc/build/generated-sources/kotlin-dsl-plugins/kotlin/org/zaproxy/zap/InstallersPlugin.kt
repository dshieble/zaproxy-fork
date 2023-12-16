package org.zaproxy.zap


/**
 * Precompiled [installers.gradle.kts][org.zaproxy.zap.Installers_gradle] script plugin.
 *
 * @see org.zaproxy.zap.Installers_gradle
 */
public
class InstallersPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("org.zaproxy.zap.Installers_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
