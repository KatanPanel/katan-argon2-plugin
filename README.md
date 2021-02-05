## Introduction
Support for the Argon2 hashing algorithm to Katan.

This plugin is self-injected at startup, you install it and it works independently.\
It is not available as a plugin on Katan Dependency Manager (KDM) only as service (via [Hash](https://github.com/KatanPanel/Katan/blob/dev/katan-api/src/main/kotlin/me/devnatan/katan/api/security/crypto/Hash.kt) injection).

## Requirements
* Argon2 C library
* [A compatible operating system](https://github.com/phxql/argon2-jvm#usage)

## Installation
* Download a release from the [releases](https://github.com/KatanPanel/katan-argon2/releases) tab.
* Put the downloaded executable in Katan's plugin folder.
* Change the hashing algorithm in the Katan configuration to `Argon2` *(security » crypto » hash)*.

## Configuration
See the full configuration [here](https://github.com/KatanPanel/katan-argon2-plugin/blob/main/src/main/resources/config.conf).

## How to use
Katan Dependency Manager (KDM) *(injection)*\
**Note:** If the plugin is not enabled and another service that adds alternative hashing algorithms is running, the injection will silently fail.
```kotlin
val hash by dependency<Hash>()
```

## License
katan-argon2-plugin uses [argon2-jvm](https://github.com/phxql/argon2-jvm) under the [LGPL v3](https://github.com/phxql/argon2-jvm/blob/master/LICENSE.txt) license.\
katan-argon2-plugin is licensed under [MIT](https://github.com/KatanPanel/katan-argon2/blob/main/LICENSE).
