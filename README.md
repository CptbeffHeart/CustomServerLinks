<h1 align="center">
    Custom Server Links
</h1>
<p align="center">
  <a href="https://github.com/CptBeffHeart/CustomServerLinks/stargazers">
    <img src="https://img.shields.io/github/stars/CptBeffHeart/CustomServerLinks">
  </a>
  <a href="https://github.com/CptbeffHeart/CustomServerLinks/releases">
    <img src="https://img.shields.io/github/downloads/CptbeffHeart/CustomServerLinks/total.svg">
  </a>
</p>

<p align="center">
  <a href="https://github.com/CptbeffHeart/DeepStorage/releases">
    <img src="https://github.com/user-attachments/assets/7620a412-97cc-47ed-9b37-c4641a3f9243">
  </a>
</p>

## Overview
CustomServerLinks Plugin is a simple yet powerful tool that allows servers to send custom links to players. With this plugin, you can enhance player interaction by providing easy access to external resources such as documentation, tutorials, or community links.

## Usage
You can add "named links" or "typed links".<br>

### Named links
Named links `name` is customizable and support colors.<br>
Named link exemple :
```
Site:
  name: "Site"
  link: "https://domain.com/"
```

### Typed links
Typed links `type` is defined by mojang.<br>
Generic-use link labels have native translations.<br>
`REPORT_BUG` links which may appear on disconnect/crash screens.<br>
Typed link exemple :
```
Site:
  type: "WEBSITE"
  link: "https://domain.com/"
```
Available types : `REPORT_BUG`, `COMMUNITY_GUIDELINES`, `SUPPORT`, `STATUS`, `FEEDBACK`, `COMMUNITY`, `WEBSITE`, `FORUMS`, `NEWS`, `ANNOUNCEMENTS`.<br>
[Default config.yml](https://github.com/CptbeffHeart/CustomServerLinks/blob/master/src/main/resources/config.yml)
| Translation key                         | Name                  |
|-----------------------------------------|-----------------------|
| known_server_link.announcements         | Announcements         |
| known_server_link.community             | Community             |
| known_server_link.community_guidelines  | Community Guidelines  |
| known_server_link.feedback              | Feedback              |
| known_server_link.forums                | Forums                |
| known_server_link.news                  | News                  |
| known_server_link.report_bug            | Report Server Bug     |
| known_server_link.status                | Status                |
| known_server_link.support               | Support               |
| known_server_link.website               | Website               |

# Provided Services

| Service type                  | Availability |
|-------------------------------|--------------|
| Updates for new MC versions   | ✔            |
| Bug fixes                     | ✔            |
| Wiki updates                  | ✔            |
| Feature requests              | ✔            |
| Customer support              | ✔            |
| Free user support             | ✔            |
| Optimization                  | ✔            |
