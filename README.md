[![](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fmaven.topi.wtf%2Freleases%2Fcom%2Fgithub%2Ftopi314%2Flavasrc%2Flavasrc%2Fmaven-metadata.xml)](https://maven.topi.wtf/#/releases/com/github/topi314/lavasrc)

# LavaSrc

> [!IMPORTANT]
> For LavaSrc v3 (Lavaplayer v1 & Lavalink v3) look [here](https://github.com/topi314/LavaSrc/tree/v3-legacy)

## Summary

* [Sources](#sources)
    * [Features](#features)
    * [What is Mirroring?](#what-is-mirroring)
* [Lavalink Usage](#lavalink-usage)
    * [Configuration](#configuration)
    * [Update Settings at Runtime](#update-settings-at-runtime)
* [Lavaplayer Usage](#lavaplayer-usage)
* [Supported URLs and Queries](#supported-urls-and-queries)

# Sources

| Source                                              | Features       | Playback                     | Credits                                                                                                                |
|-----------------------------------------------------|----------------|------------------------------|------------------------------------------------------------------------------------------------------------------------|
| Spotify                                             | 📁💿🎵🧑🔍🔬📜 | [Mirror](#what-is-mirroring) | [@topi314](https://github.com/topi314)                                                                                 |
| Apple Music                                         | 📁💿🎵🧑🔍🔬📜 | [Mirror](#what-is-mirroring) | [@ryan5453](https://github.com/ryan5453)                                                                               |
| Deezer                                              | 📁💿🎵🧑🔍🔬📜 | Direct                       | [@topi314](https://github.com/topi314), [@ryan5453](https://github.com/ryan5453), [@viztea](https://github.com/viztea) |
| Yandex                                              | 📁💿🎵🧑🔍🔬📜 | Direct                       | [@agutinvboy](https://github.com/agutinvboy)                                                                           |
| Flowery TTS                                         |                | Direct                       | [@bachtran02](https://github.com/bachtran02)                                                                           |
| YouTube (Music)                                     | 🔬📜           | N/A                          | [@topi314](https://github.com/topi314), [@DRSchlaubi](https://github.com/DRSchlaubi)                                   |
| VK Music                                            | 📁💿🎵🧑🔍🔬📜 | Direct                       | [@Krispeckt](https://github.com/Krispeckt)                                                                             |
| Tidal                                               | 📁💿🎵🧑       | [Mirror](#what-is-mirroring) | [@nansess](https://github.com/nansess), [@InfNibor](https://github.com/InfNibor)                                       |
| Qobuz                                               | 📁💿🎵🧑       | Direct                       | [@munishkhatri720](https://github.com/munishkhatri720)                                                                 |
| YouTube([yt-dlp](https://github.com/yt-dlp/yt-dlp)) | 📁💿🎵🧑🔍     | Direct                       | [@topi314](https://github.com/topi314)                                                                                 |
| Lastfm | 📁💿🎵🧑🔍🔬📜 | [Mirror](#what-is-mirroring) | [@asynico](https://github.com/asynico)                                                                                                                                   |

### Features

- 📁 playlists
- 💿 albums
- 🎵 tracks
- 🧑 artist top tracks
- 🔍 search results
- 🔬 [LavaSearch](https://github.com/topi314/LavaSearch)
- 📜 [LavaLyrics](https://github.com/topi314/LavaLyrics)

> [!IMPORTANT]
> ### What is Mirroring?
>
> Mirroring is the process of taking the metadata resolved from one source and using it to retrieve a playable `AudioTrack` from another.
>
> For example, LavaSrc cannot directly play from Spotify, or any source marked as `Mirror` playback, so it must use a LavaSrc platform marked as `Direct`, like Deezer.
> You may also use any source manager registered to your `AudioPlayerManager`.

## Lavalink Usage

This plugin requires Lavalink `v4` or greater

To install this plugin either download the latest release and place it into your `plugins` folder or add the following into your `application.yml`

> [!Note]
> For a full `application.yml` example see [here](application.example.yml)

Replace x.y.z with the latest version number

```yaml
lavalink:
  plugins:
    - dependency: "com.github.topi314.lavasrc:lavasrc-plugin:x.y.z"
      repository: "https://maven.lavalink.dev/releases" # this is optional for lavalink v4.0.0-beta.5 or greater
      snapshot: false # set to true if you want to use snapshot builds (see below)
```

Snapshot builds are available in https://maven.lavalink.dev/snapshots with the short commit hash as the version

### Configuration

For all supported urls and queries see [here](#supported-urls-and-queries)

To get your Spotify clientId, clientSecret go [here](https://developer.spotify.com/dashboard/applications) & then copy them into your `application.yml` like the following.

To get your Spotify spDc cookie go [here](#spotify)

To get your Apple Music api token go [here](#apple-music)

To get your Deezer arl cookie go [here](#deezer)

To get your Yandex Music access token go [here](#yandex-music)

To get your Vk Music user token go [here](#vk-music)

To get your Tidal token go [here](#tidal)

To get your Qobuz userOauthToken go [here](#qobuz)

To get your Last.fm api key go [here](#Lastfm)

> [!WARNING]
> YES `plugins` IS AT ROOT IN THE YAML

```yaml
plugins:
  lavasrc:
    providers: # Custom providers for track loading. This is the default
      # - "dzisrc:%ISRC%" # Deezer ISRC provider
      # - "dzsearch:%QUERY%" # Deezer search provider
      - "ytsearch:\"%ISRC%\"" # Will be ignored if track does not have an ISRC. See https://en.wikipedia.org/wiki/International_Standard_Recording_Code
      - "ytsearch:%QUERY%" # Will be used if track has no ISRC or no track could be found for the ISRC
      #  you can add multiple other fallback sources here
    sources:
      spotify: false # Enable Spotify source
      applemusic: false # Enable Apple Music source
      deezer: false # Enable Deezer source
      yandexmusic: false # Enable Yandex Music source
      flowerytts: false # Enable Flowery TTS source
      youtube: false # Enable YouTube search source (https://github.com/topi314/LavaSearch)
      vkmusic: false # Enable Vk Music source
      tidal: false # Enable Tidal source
      qobuz : false # Enabled qobuz source
      ytdlp: false # Enable yt-dlp source
    lyrics-sources:
      spotify: false # Enable Spotify lyrics source
      deezer: false # Enable Deezer lyrics source
      youtube: false # Enable YouTube lyrics source
      yandexmusic: false # Enable Yandex Music lyrics source
      vkmusic: false # Enable Vk Music lyrics source
    spotify:
      # clientId & clientSecret are required for using spsearch
#      clientId: "your client id"
#      clientSecret: "your client secret"
      # spDc: "your sp dc cookie" # the sp dc cookie used for accessing the spotify lyrics api
      countryCode: "US" # the country code you want to use for filtering the artists top tracks. See https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2
      playlistLoadLimit: 6 # The number of pages at 100 tracks each
      albumLoadLimit: 6 # The number of pages at 50 tracks each
      resolveArtistsInSearch: true # Whether to resolve artists in track search results (can be slow)
      localFiles: false # Enable local files support with Spotify playlists. Please note `uri` & `isrc` will be `null` & `identifier` will be `"local"`
      preferAnonymousToken: false # Whether to use the anonymous token for resolving tracks, artists and albums. Spotify generated playlists are always resolved with the anonymous tokens since they do not work otherwise. This requires the customTokenEndpoint to be set.
      customTokenEndpoint: "http://localhost:8080/api/token" # Optional custom endpoint for getting the anonymous token. If not set, spotify's default endpoint will be used which might not work. The response must match spotify's anonymous token response format.
    applemusic:
      countryCode: "US" # the country code you want to use for filtering the artists top tracks and language. See https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2
      mediaAPIToken: "your apple music api token" # apple music api token
      # or specify an apple music key
      keyID: "your key id"
      teamID: "your team id"
      musicKitKey: |
        -----BEGIN PRIVATE KEY-----
        your key
        -----END PRIVATE KEY-----      
      playlistLoadLimit: 6 # The number of pages at 300 tracks each
      albumLoadLimit: 6 # The number of pages at 300 tracks each
    deezer:
      masterDecryptionKey: "your master decryption key" # the master key used for decrypting the deezer tracks. (yes this is not here you need to get it from somewhere else)
      arl: "your deezer arl" # the arl cookie used for accessing the deezer api this is not optional anymore
      formats: [ "FLAC", "MP3_320", "MP3_256", "MP3_128", "MP3_64", "AAC_64" ] # the formats you want to use for the deezer tracks. "FLAC", "MP3_320", "MP3_256" & "AAC_64" are only available for premium users and require a valid arl
    yandexmusic:
      accessToken: "your access token" # the token used for accessing the yandex music api. See https://github.com/topi314/LavaSrc#yandex-music
      playlistLoadLimit: 1 # The number of pages at 100 tracks each
      albumLoadLimit: 1 # The number of pages at 50 tracks each
      artistLoadLimit: 1 # The number of pages at 10 tracks each
    flowerytts:
      voice: "default voice" # (case-sensitive) get default voice from here https://api.flowery.pw/v1/tts/voices
      translate: false # whether to translate the text to the native language of voice
      silence: 0 # the silence parameter is in milliseconds. Range is 0 to 10000. The default is 0.
      speed: 1.0 # the speed parameter is a float between 0.5 and 10. The default is 1.0. (0.5 is half speed, 2.0 is double speed, etc.)
      audioFormat: "mp3" # supported formats are: mp3, ogg_opus, ogg_vorbis, aac, wav, and flac. Default format is mp3
    youtube:
      countryCode: "US" # the country code you want to use for searching & lyrics. See https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2
      language: "en" # the language code you want to use for searching & lyrics. See https://en.wikipedia.org/wiki/List_of_ISO_639_language_codes
    vkmusic:
      userToken: "your user token" # This token is needed for authorization in the api. Guide: https://github.com/topi314/LavaSrc#vk-music
      playlistLoadLimit: 1 # The number of pages at 50 tracks each
      artistLoadLimit: 1 # The number of pages at 10 tracks each
      recommendationsLoadLimit: 10 # Number of tracks
    tidal:
      countryCode: "US" # the country code for accessing region-specific content on Tidal (ISO 3166-1 alpha-2).
      searchLimit: 6 # How many search results should be returned
      token: "your tidal token" # the token used for accessing the tidal api. See https://github.com/topi314/LavaSrc#tidal
    qobuz:
      userOauthToken : "your user oauth token" # This token is needed for authorization in the api. Guide: https://github.com/topi314/LavaSrc#qobuz
      #      appId : optional (Only pass it when you are using an old userOauthToken)
      #      appSecret : optional (Only pass it when you are using an old userOauthToken)
    ytdlp:
      path: "yt-dlp" # the path to the yt-dlp executable.
      searchLimit: 10 # How many search results should be returned
#      customLoadArgs: ["-q", "--no-warnings", "--flat-playlist", "--skip-download", "-J"] # Custom arguments to pass to yt-dlp
#      customPlaybackArgs: ["-q", "--no-warnings", "-f", "bestaudio", "-J"] # Custom arguments for yt-dlp
```

### Plugin Info

LavaSrc adds the following fields to tracks & playlists in Lavalink

#### Track

| Field            | Type    | Description                    |
|------------------|---------|--------------------------------|
| albumName        | ?string | The name of the album          |
| albumArtUrl      | ?string | The url of the album art       |
| artistUrl        | ?string | The url of the artist          |
| artistArtworkUrl | ?string | The url of the artist artwork  |
| previewUrl       | ?string | The url of the preview         |
| isPreview        | bool    | Whether the track is a preview |

<details>
<summary>Example Payload</summary>

```json
{
  "encoded": "...",
  "info": {
    ...
  },
  "pluginInfo": {
    "albumName": "...",
    "albumArtUrl": "...",
    "artistUrl": "...",
    "artistArtworkUrl": "...",
    "previewUrl": "...",
    "isPreview": false
  },
  "userData": {
    ...
  }
}
```

</details>

#### Playlist

| Field       | Type                             | Description                                |
|-------------|----------------------------------|--------------------------------------------|
| type        | [Playlist Type](#playlist-types) | The type of the playlist                   |
| url         | ?string                          | The url of the playlist                    |
| artworkUrl  | ?string                          | The url of the playlist artwork            |
| author      | ?string                          | The author of the playlist                 |
| totalTracks | ?int                             | The total number of tracks in the playlist |

<details>
<summary>Example Payload</summary>

```json
{
  "info": {
    ...
  },
  "pluginInfo": {
    "type": "playlist",
    "url": "...",
    "artworkUrl": "...",
    "author": "...",
    "totalTracks": 10
  },
  "tracks": [
    ...
  ]
}
```

</details>

#### Playlist Types

| Type              | Description                                |
|-------------------|--------------------------------------------|
| `album`           | The playlist is an album                   |
| `playlist`        | The playlist is a playlist                 |
| `artist`          | The playlist is an artist                  |
| `recommendations` | The playlist is a recommendations playlist |

---

### Update Settings at Runtime

Sometimes you may want to update the settings at runtime without restarting Lavalink. This can be done by sending a `PATCH` request to the `/v4/lavasrc/config` endpoint.
Keep in mind this will **NOT** update the settings in the `application.yml` file. If you restart Lavalink the settings will be reset to the ones in the `application.yml` file.

```http
PATCH /v4/lavasrc/config
```

#### LavaSrc Config Object

> [!NOTE]
> All fields are optional and only the fields you provide will be updated.

| Field        | Type                                               | Description               |
|--------------|----------------------------------------------------|---------------------------|
| ?spotify     | [Spotify Config](#spotify-config-object)           | The Spotify settings      |
| ?applemusic  | [Apple Music Config](#apple-music-config-object)   | The Apple Music settings  |
| ?deezer      | [Deezer Config](#deezer-config-object)             | The Deezer settings       |
| ?yandexMusic | [Yandex Music Config](#yandex-music-config-object) | The Yandex Music settings |
| ?vkMusic     | [Vk Music Config](#vk-music-config-object)         | The Vk Music settings     |
| ?qobuz       | [Qobuz Config](#qobuz-config-object)               | The Qobuz settings        |
| ?lastfm      | [Lastfm Config](#lastfm-config-object)             | The Lastfm settings       |

##### Spotify Config Object

| Field                 | Type    | Description                                                                 |
|-----------------------|---------|-----------------------------------------------------------------------------|
| ?clientId             | string  | The Spotify clientId                                                        |
| ?clientSecret         | string  | The Spotify clientSecret                                                    |
| ?spDc                 | string  | The Spotify spDc cookie                                                     |
| ?preferAnonymousToken | boolean | Whether to use the anonymous token for resolving tracks, artists and albums |
| ?customTokenEndpoint  | string  | The custom endpoint for getting the anonymous token                         |

##### Apple Music Config Object

| Field          | Type   | Description               |
|----------------|--------|---------------------------|
| ?mediaAPIToken | string | The Apple Music api token |

##### Deezer Config Object

| Field    | Type                                      | Description           |
|----------|-------------------------------------------|-----------------------|
| ?arl     | string                                    | The Deezer arl cookie |
| ?formats | array of [Deezer Format](#deezer-formats) | The Deezer formats    |

##### Deezer Formats

| Format    | Description |
|-----------|-------------|
| `FLAC`    | FLAC        |
| `MP3_320` | MP3 320kbps |
| `MP3_256` | MP3 256kbps |
| `MP3_128` | MP3 128kbps |
| `MP3_64`  | MP3 64kbps  |
| `AAC_64`  | AAC 64kbps  |

##### Yandex Music Config Object

| Field        | Type   | Description                   |
|--------------|--------|-------------------------------|
| ?accessToken | string | The Yandex Music access token |

##### Vk Music Config Object

| Field      | Type   | Description             |
|------------|--------|-------------------------|
| ?userToken | string | The Vk Music user token |

#### Qobuz Config Object

| Field           | Type   | Description          |
|-----------------|--------|----------------------|
| ?userOauthToken | string | The Qobuz user token |
| ?appId          | String | The Qobuz App ID     |
| ?appSecret      | string | The Qobuz App Secret |

#### Lastfm Config Object

| Field             | Type   | Description             |
|-------------------|--------|-------------------------|
| ?apiKey           | string | The last.fm api key     |
| ?playlistLoadLimit| int    | The playlist load limit |


<details>
<summary>Example Payload</summary>

```json
{
  "spotify": {
    "clientId": "your client id",
    "clientSecret": "your client secret",
    "spDc": "your sp dc cookie", 
    "preferAnonymousToken": false,
    "customTokenEndpoint": "http://localhost/api/token"
  },
  "applemusic": {
    "mediaAPIToken": "your apple music api token"
  },
  "deezer": {
    "arl": "your deezer arl",
    "formats": [
      "FLAC",
      "MP3_320",
      "MP3_256",
      "MP3_128",
      "MP3_64",
      "AAC_64"
    ]
  },
  "yandexMusic": {
    "accessToken": "your access token"
  },
  "vkMusic": {
    "userToken": "your user token"
  },
  "qobuz": {
    "userOauthToken": "your user token",
    "appId": "your app ID",
    "appSecret": "your app Secret"
  },
  "ytdlp": {
    "path": "yt-dlp",
    "customLoadArgs": ["-q", "--no-warnings", "--flat-playlist", "--skip-download", "-J"],
    "customPlaybackArgs": ["-q", "--no-warnings", "-f", "bestaudio", "-J"]
  },
  "lastfm": {
    "apiKey": "your last.fm api key",
    "playlistLoadLimit": 10
  }
}
```

</details>

---

## Lavaplayer Usage

Replace `x.y.z` with the latest version number

Snapshot builds are instead available in https://maven.topi.wtf/snapshots with the short commit hash as the version

### Using in Gradle:

<details>
<summary>Gradle</summary>

```gradle
repositories {
  maven {
    url "https://maven.topi.wtf/releases"
  }
}

dependencies {
  implementation "com.github.topi314.lavasrc:lavasrc:x.y.z"
  implementation "com.github.topi314.lavasrc:lavasrc-protocol:x.y.z"
}
```

</details>

### Using in Maven:

<details>
<summary>Maven</summary>

```xml
<repositories>
  <repository>
    <id>TopiWTF-releases</id>
    <name>Topis Maven Repo</name>
    <url>https://maven.topi.wtf/releases</url>
  </repository>
</repositories>

<dependencies>
  <dependency>
    <groupId>com.github.topi314.lavasrc</groupId>
    <artifactId>lavasrc</artifactId>
    <version>x.y.z</version>
  </dependency>
  <dependency>
    <groupId>com.github.topi314.lavasrc</groupId>
    <artifactId>lavasrc-protocol-jvm</artifactId>
    <version>x.y.z</version>
  </dependency>
</dependencies>
```

</details>

---

### Spotify

To get a Spotify clientId & clientSecret you must go [here](https://developer.spotify.com/dashboard) and create a new application.

<details>
<summary>How to get sp dc cookie</summary>

1. Go to https://open.spotify.com
2. Open DevTools and go to the Application tab
3. Copy the value of the `sp_dc` cookie

</details>

```java
AudioPlayerManager playerManager = new DefaultAudioPlayerManager();

// create a new SpotifySourceManager with the default providers, clientId, clientSecret, spDc, countryCode and AudioPlayerManager and register it
// spDc is only needed if you want to use it with LavaLyrics
var spotify = new SpotifySourceManager(clientId, clientSecret, spDc, countryCode, () -> playerManager, DefaultMirroringAudioTrackResolver);
playerManager.registerSourceManager(spotify);
```

#### Access Tokens

Getting anonymous & account access tokens is generally optional but required if you want to resolve spotify generated playlists or lyrics.

You can use a service such as [Spotify Tokener](https://github.com/topi314/spotify-tokener) via the `customTokenEndpoint` option to support those.

#### LavaLyrics

<details>
<summary>Click to expand</summary>

```java
// create new lyrics manager
var lyricsManager = new LyricsManager();

// register source
lyricsManager.registerLyricsManager(spotify);
```

</details>

#### LavaSearch

<details>
<summary>Click to expand</summary>

```java
// create new search manager
var searchManager = new SearchManager();

// register source
searchManager.registerSearchManager(spotify);
```

</details>

---

### Apple Music

<details>
<summary>How to get media api token without Apple developer account</summary>

1. Go to https://music.apple.com
2. Open DevTools and go to the Debugger tab
3. Search with this regex `"(?<token>(ey[\w-]+)\.([\w-]+)\.([\w-]+))"` in all `index-*.js` files
4. Copy the token from the source code

</details>

Alternatively, you can
follow [this guide](https://developer.apple.com/help/account/configure-app-capabilities/create-a-media-identifier-and-private-key/)

```java
AudioPlayerManager playerManager = new DefaultAudioPlayerManager();

// create a new AppleMusicSourceManager with the standard providers, apple music api token, countrycode and AudioPlayerManager and register it
var appleMusic = new AppleMusicSourceManager(null, mediaAPIToken, "us", playerManager);
playerManager.registerSourceManager(appleMusic);
```

#### LavaSearch

<details>
<summary>Click to expand</summary>

```java
// create new search manager
var searchManager = new SearchManager();

// register source
searchManager.registerSearchManager(appleMusic);
```

</details>

---

### Deezer

<details>
<summary>How to get deezer master decryption key</summary>

Use Google.

</details>

<details>
<summary>How to get deezer arl cookie</summary>

Use Google to find a guide on how to get the arl cookie. It's not that hard.

</details>

```java
AudioPlayerManager playerManager = new DefaultAudioPlayerManager();

// create a new DeezerSourceManager with the master decryption key and register it

var deezer = new DeezerSourceManager("the master decryption key", "your arl", formats);
playerManager.registerSourceManager(deezer);
```

#### LavaLyrics

<details>
<summary>Click to expand</summary>

```java
// create new lyrics manager
var lyricsManager = new LyricsManager();

// register source
lyricsManager.registerLyricsManager(deezer);
```

</details>

#### LavaSearch

<details>
<summary>Click to expand</summary>

```java
// create new search manager
var searchManager = new SearchManager();

// register source
searchManager.registerSearchManager(deezer);
```

</details>

---

### Yandex Music

<details>
<summary>How to get access token</summary>

1. (Optional) Open DevTools in your browser and on the Network tab enable trotlining.
2. Go to https://oauth.yandex.ru/authorize?response_type=token&client_id=23cabbbdc6cd418abb4b39c32c41195d
3. Authorize and grant access
4. The browser will redirect to the address like `https://music.yandex.ru/#access_token=AQAAAAAYc***&token_type=bearer&expires_in=31535645`. 
   Very quickly there will be a redirect to another page, so you need to have time to copy the link. ![image](https://user-images.githubusercontent.com/68972811/196124196-a817b828-3387-4f70-a2b2-cdfdc71ce1f2.png)
5. Your accessToken, what is after `access_token`.

#### Important information

Yandex Music is very location-dependent. You should either have a premium subscription or be located in one of the following countries:

- Azerbaijan
- Armenia
- Belarus
- Georgia
- Kazakhstan
- Kyrgyzstan
- Moldova
- Russia
- Tajikistan
- Turkmenistan
- Uzbekistan

Else you will only have access to podcasts.
</details>

```java
AudioPlayerManager playerManager = new DefaultAudioPlayerManager();

// create a new YandexMusicSourceManager with the access token and register it
var yandex = new YandexMusicSourceManager("...");

playerManager.registerSourceManager(yandex);
```

#### LavaLyrics

<details>
<summary>Click to expand</summary>

```java
// create new lyrics manager
var lyricsManager = new LyricsManager();

// register source
lyricsManager.registerLyricsManager(yandex);
```

</details>

#### LavaSearch

<details>
<summary>Click to expand</summary>

```java
// create new search manager
var searchManager = new SearchManager();

// register source
searchManager.registerSearchManager(yandex);
```

</details>

---

### Flowery Text-to-Speech

Get list of all voices and languages supported [here](https://api.flowery.pw/v1/tts/voices)

```java
AudioPlayerManager playerManager = new DefaultAudioPlayerManager();

// create a new FloweryTTSSourceManager 
playerManager.registerSourceManager(new FloweryTTSSourceManager());
// create a new FloweryTTSSourceManager with a default voice
playerManager.registerSourceManager(new FloweryTTSSourceManager("..."));
```

---

### Vk Music

<details>
<summary>How to get user token</summary>

### WARNING!

#### Carefully, this token can be used to access your personal data. Use a newly created account specifically for LavaSrc. This source is designed mainly for the RU region, 80% of songs in other regions will not be played.

1. Go to the authorization page [Marusya application](https://oauth.vk.com/authorize?client_id=6463690&scope=1073737727&redirect_uri=https://oauth.vk.com/blank.html&display=page&response_type=token&revoke=1)
2. Authorize through your vk account.
3. A link like this `https://oauth.vk.com/blank.html#access_token=$$$$$&expires_in=0&user_id=$$$$$@email=$$$$$@gmail.com`
4. Copy your token and paste it into your config! Enjoy captcha-free vk music!

</details>

```java
AudioPlayerManager playerManager = new DefaultAudioPlayerManager();

// create a new VkMusicSourceManager with the user token and register it
playerManager.registerSourceManager(new VkMusicSourceManager("...");
```

#### LavaLyrics

<details>
<summary>Click to expand</summary>

```java
// create new lyrics manager
var lyricsManager = new LyricsManager();

// register source
lyricsManager.registerLyricsManager(vkmusic);
```

</details>

#### LavaSearch

<details>
<summary>Click to expand</summary>

```java
// create new search manager
var searchManager = new SearchManager();

// register source
searchManager.registerSearchManager(vkmusic);
```

</details>

---

### Tidal

<details>
<summary>How to get tidal token</summary>

Use Google to get the tidal token.

</details>

```java
AudioPlayerManager playerManager = new DefaultAudioPlayerManager();

// create a new TidalSourceManager with the token and register it
var tidal = new TidalSourceManager(countryCode, () -> playerManager, new DefaultMirroringAudioTrackResolver(providers), "your tidal token");

playerManager.registerSourceManager(tidal);
```

### Qobuz

<details>
<summary>How to get the userOauthToken</summary>

### WARNING!

#### If you are using an older userOauthToken, you must specify the `x-app-id` in the config. Each userOauthToken is associated with a specific app ID. If you don't specify the `x-app-id` in the config, the latest fetched one will be used and it may not work. Remember that Qobuz requires a premium account to work properly.

To retrieve the token:
1. Open Qobuz in any web browser and log in with your Qobuz account.
2. Press **F12** to open the developer tools and navigate to the **Network** tab.
3. Select any request and check the request headers.
> When looking for a request, you must find a POST request - not OPTIONS! 
4. Copy the value of the `x-user-auth-token` and paste it into the config.

</details>

```java
AudioPlayerManager playerManager = new DefaultAudioPlayerManager();

// create a new QobuzAudioSourceManager with the userOauthToken and register it
playerManager.registerSourceManager(new QobuzAudioSourceManager("...");
```

### yt-dlp

```java
AudioPlayerManager playerManager = new DefaultAudioPlayerManager();

// create a new YTDLPSourceManager with the path to the yt-dlp executable and register it
playerManager.registerSourceManager(new YTDLPSourceManager("path/to/yt-dlp"));
```

### Lastfm

To get a Last.fm api key you must go [here](https://www.last.fm/api/account/create) and create the application.

```java
AudioPlayerManager playerManager = new DefaultAudioPlayerManager();

// create a new LastfmSourceManager with the default providers, apiKey and AudioPlayerManager and register it
var lastfm = new LastfmSourceManager(apiKey, unused -> playerManager, new DefaultMirroringAudioTrackResolver(null));
playerManager.registerSourceManager(lastfm);
```

---
## Supported URLs and Queries

### Spotify

* `spsearch:animals architects` (check out [Spotify Search Docs](https://developer.spotify.com/documentation/web-api/reference/search) for advanced search queries like isrc & co)
* `sprec:seed_artists=3ZztVuWxHzNpl0THurTFCv,4MzJMcHQBl9SIYSjwWn8QW&seed_genres=metalcore&seed_tracks=5ofoB8PFmocBXFBEWVb6Vz,6I5zXzSDByTEmYZ7ePVQeB`
  (only works in [Extended quota mode](https://developer.spotify.com/documentation/web-api/concepts/quota-modes#extended-quota-mode) or with anonymous tokens, check out [Spotify Recommendations Docs](https://developer.spotify.com/documentation/web-api/reference/get-recommendations) for the full query parameter list)
* https://open.spotify.com/track/0eG08cBeKk0mzykKjw4hcQ
* https://open.spotify.com/album/7qemUq4n71awwVPOaX7jw4
* https://open.spotify.com/playlist/7HAO9R9v203gkaPAgknOMp (playlists can include local files if you enabled this via: `plugins.lavasrc.spotify.localFiles: true`. Please note `uri` & `isrc` will be `null` & `identifier` will be `"local"`)
* https://open.spotify.com/artist/3ZztVuWxHzNpl0THurTFCv

(including new regional links like https://open.spotify.com/intl-de/track/0eG08cBeKk0mzykKjw4hcQ)

### Apple Music

* `amsearch:animals architects`
* https://music.apple.com/cy/album/animals/1533388849?i=1533388859
* https://music.apple.com/cy/album/for-those-that-wish-to-exist/1533388849
* https://music.apple.com/us/playlist/architects-essentials/pl.40e568c609ae4b1eba58b6e89f4cd6a5
* https://music.apple.com/cy/artist/architects/182821355

### Deezer

* `dzsearch:animals architects`
* `dzisrc:USEP42058010`
* `dzrec:1090538082` (`dzrec:{TRACK_ID}`, `dzrec:track={TRACK_ID}` or `dzrec:artist={ARTIST_ID}`)
* https://deezer.page.link/U6BTQ2Q1KpmNt2yh8
* https://www.deezer.com/track/1090538082
* https://www.deezer.com/album/175537082
* https://www.deezer.com/playlist/8164349742
* https://www.deezer.com/artist/159126

### Yandex Music

* `ymsearch:animals architects`
* `ymrec:71663565` (`ymrec:{TRACK_ID}`)
* https://music.yandex.ru/album/13886032/track/71663565
* https://music.yandex.ru/album/13886032
* https://music.yandex.ru/track/71663565
* https://music.yandex.ru/users/yamusic-bestsongs/playlists/701626
* https://music.yandex.ru/artist/701626

### Flowery TTS

You can read about all the available options [here](https://flowery.pw/docs), a list of available voices is [here](https://api.flowery.pw/v1/tts/voices)

* `ftts://hello%20world`
* `ftts://hello%20world?audio_format=ogg_opus&translate=False&silence=1000&speed=1.0&voice=09924826-684f-51e9-825b-cf85aed2b2cf`

### Vk Music

* `vksearch:animals architects`
* `vkrec:-2001015907_104015907` (`vkrec:{TRACK_ID}`)
* https://vk.com/audio-2001015907_104015907
* https://vk.ru/artist/shadxwbxrn
* https://vk.com/audios700949584?q=phonk%20playlist&z=audio_playlist-219343251_152_389941c481d1375ac0
* https://vk.com/audios700949584?q=phonk%20playlist&z=audio_playlist-219343251_152
* https://vk.com/music/playlist/-219343251_152_389941c481d1375ac0
* https://vk.ru/music/playlist/-219343251_152
* https://vk.com/music/album/-2000228258_15228258_cafcb9e95f552acbb6?act=album
* https://vk.com/music/album/-2000228258_15228258_cafcb9e95f552acbb6
* https://vk.ru/music/album/-2000228258_15228258?act=album
* https://vk.com/music/album/-2000228258_15228258
* https://vk.com/audios700949584?q=phonk%20album&z=audio_playlist-2000933493_13933493%2Fbe3494d46d310b0d0d
* https://vk.ru/audios700949584?q=phonk%20album&z=audio_playlist-2000933493_13933493

### Tidal

* `tdsearch:animals architects`
* `tdrec:12345678` (`tdrec:{TRACK_ID}`)
* https://tidal.com/browse/track/12345678
* https://tidal.com/browse/album/12345678
* https://tidal.com/browse/playlist/12345678
* https://tidal.com/browse/artist/12345678

### Qobuz 

* `qbsearch:animals architects`
* `qbisrc:USEP42058010` (`qbisrc:ISRC`)
* `qbrec:295210968` (`qbrec:{TRACK_ID}`)
* https://open.qobuz.com/track/52151405
* https://play.qobuz.com/album/c9wsrrjh49ftb
* https://play.qobuz.com/playlist/24893079
* https://play.qobuz.com/artist/2070395
* https://www.qobuz.com/us-en/album/kesariya-pritam-arijit-singh-amitabh-bhattacharya/cxtiqss1up8ub

### yt-dlp

* `ytsearch:animals architects`
* `ytsearch:"USEP42058010"` (`ytsearch:"{ISRC}"`)
* https://www.youtube.com/watch?v=jdWhJcrrjQs
* https://www.youtube.com/watch?v=yEBEg4NGVrw&list=PLcZMZxR9uxC8EGrCPopQT1JjNTV6nnQ1G
* https://youtu.be/jdWhJcrrjQs

### lastfm

* `lfsearch:animals architects`
* `lfsearch:"12345678"` (`lfsearch:"{ISRC}"`)
* https://www.last.fm/music/artist/track
* https://www.last.fm/music/artist/1+2+3+4+5+6
https://www.last.fm/music/playlist+url
---
