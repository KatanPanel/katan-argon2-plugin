package me.devnatan.katan.plugin.argon2

import me.devnatan.katan.api.annotations.UnstableKatanApi
import me.devnatan.katan.api.plugin.KatanPlugin
import me.devnatan.katan.api.plugin.PluginDisabled
import me.devnatan.katan.api.plugin.PluginEnabled
import me.devnatan.katan.api.plugin.handle
import me.devnatan.katan.api.security.crypto.Hash

@OptIn(UnstableKatanApi::class)
class Argon2Plugin : KatanPlugin("katan-argon2", "0.0.1", "DevNatan") {

    init {
        handle(PluginEnabled, ::onStart)
        handle(PluginDisabled, ::onStop)
    }

    private fun onStart() {
        katan.servicesManager.register(Hash::class, Argon2Hash(config))
    }

    private fun onStop() {
        katan.servicesManager.unregister(Hash::class)
    }

}