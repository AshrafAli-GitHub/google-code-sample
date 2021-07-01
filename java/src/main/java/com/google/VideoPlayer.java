package com.google;

import java.util.*;
import java.util.stream.Collectors;

public class VideoPlayer {

  private final VideoLibrary videoLibrary;
  String videoPlaying = "none";
  boolean isPaused = false;
  String currentID = "none";

  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {
    List<Video> sortedList = videoLibrary.getVideos().stream()
            .sorted(Comparator.comparing(Video::getTitle))
            .collect(Collectors.toList());

    System.out.println("Here's a list of all available videos:");

    for (int i = 0; i < videoLibrary.getVideos().size(); i++){
      Video x = sortedList.get(i);
      System.out.printf("    %s (%s) %s %n", x.getTitle(), x.getVideoId(), x.getTags());
    }
  }

  public void playVideo(String videoId) {
    currentID = videoId;
    try {
      if(!"none".equals(videoPlaying)){
        stopVideo();
        isPaused = false;
      }
      videoPlaying = videoLibrary.getVideo(videoId).getTitle();
      System.out.println("Playing video: " + videoPlaying);
    }
    catch(Exception e){
      System.out.println("Cannot play video: Video does not exist");
    }
  }

  public void stopVideo() {
    if(!"none".equals(videoPlaying)){
      System.out.println("Stopping video: " + videoPlaying);
      videoPlaying = "none";
    }
    else{
      System.out.println("Cannot stop video: No video is currently playing");
    }
  }

  public void playRandomVideo() {
    if(!"none".equals(videoPlaying)){
      stopVideo();
    }

    Random rand = new Random();
    int r = rand.nextInt(videoLibrary.getVideos().size());

    String randId = videoLibrary.getVideos().get(r).getVideoId();
    playVideo(randId);
  }

  public void pauseVideo() {
    if(isPaused){
      System.out.println("Video already paused: " + videoPlaying);
    }
    else{
      if(videoPlaying.equals("none")){
        System.out.println("Cannot pause video: No video is currently playing");
      }
      else{
        System.out.println("Pausing video: " + videoPlaying);
        isPaused = true;
      }
    }

  }

  public void continueVideo() {
    if(!isPaused){
      System.out.println("Cannot continue video: No video is currently playing");
    }
    else{
      System.out.println("Continuing video: " + videoPlaying);
      isPaused = false;
    }
  }

  public void showPlaying() {
    String paused = "";
    if("none".equals(videoPlaying)){
      System.out.println("No video is currently playing");
    }
    else{
      Video v = videoLibrary.getVideo(currentID);
      if(isPaused){
        paused = " - PAUSED";
      }
      System.out.printf("Currently playing: %s (%s) %s%s", v.getTitle(), v.getVideoId(), v.getTags(), paused);
    }
  }

  public void createPlaylist(String playlistName) {
    System.out.println("createPlaylist needs implementation");
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    System.out.println("addVideoToPlaylist needs implementation");
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
}