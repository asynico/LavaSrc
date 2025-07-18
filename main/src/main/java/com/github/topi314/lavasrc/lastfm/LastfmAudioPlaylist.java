package com.github.topi314.lavasrc.lastfm;

import com.github.topi314.lavasrc.ExtendedAudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;

import java.util.List;

public class LastfmAudioPlaylist extends ExtendedAudioPlaylist {

    public LastfmAudioPlaylist(String name, List<AudioTrack> tracks, Type type, String url, String artworkURL, String author, Integer totalTracks) {
        super(name, tracks, type, url, artworkURL, author, totalTracks);
    }
}
