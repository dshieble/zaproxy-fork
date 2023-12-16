package org.zaproxy.zap


/**
 * Precompiled [distributions.gradle.kts][org.zaproxy.zap.Distributions_gradle] script plugin.
 *
 * @see org.zaproxy.zap.Distributions_gradle
 */
public
class DistributionsPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("org.zaproxy.zap.Distributions_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
