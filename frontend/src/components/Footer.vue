<script></script>

<template>
  <div class="footer">
    <div class="horizontal">
      <div class="vertical">
        <p class="theme-header">Site</p>
        <a class="link">Home</a>
        <RouterLink :to="{ name: 'about' }">
          <a class="link">About</a>
        </RouterLink>
        <a class="link">Contact</a>
      </div>
      <div class="vertical">
        <p class="theme-header">Explore</p>
        <RouterLink :to="{ name: 'episodes' }">
          <a class="link">Episodes</a>
        </RouterLink>
        <RouterLink :to="{ name: 'characters' }">
          <a class="link">Characters</a>
        </RouterLink>
        <a class="link">Gallery</a>
      </div>
      <div class="vertical">
        <p class="theme-header">Follow</p>
        <a class="link" href="https://www.facebook.com/" target="_blank">Facebook</a>
        <a class="link" href="https://twitter.com/i/flow/login" target="_blank">Twitter</a>
        <a class="link" href="https://www.instagram.com/" target="_blank">Instagram</a>
      </div>
    </div>
    <div class="copyright">
      <p class="_2023-all-rights-reserved">© 2023 Futurama Fan Hub. All rights reserved.</p>
      <div class="icons">
        <!-- Instagram -->
        <a href="https://www.instagram.com/" target="_blank">
          <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20">
            <path d="M 0 0 L 20 0 L 20 20 L 0 20 Z" fill="transparent"></path>
            <path
              d="M 7.5 10 C 7.5 8.619 8.619 7.5 10 7.5 C 11.381 7.5 12.5 8.619 12.5 10 C 12.5 11.381 11.381 12.5 10 12.5 C 8.619 12.5 7.5 11.381 7.5 10 Z"
              fill="#000000"
            ></path>
            <path
              d="M 13.438 2.188 L 6.563 2.188 C 4.146 2.188 2.188 4.146 2.188 6.563 L 2.188 13.438 C 2.188 15.854 4.146 17.813 6.563 17.813 L 13.438 17.813 C 15.854 17.813 17.813 15.854 17.813 13.438 L 17.813 6.563 C 17.813 4.146 15.854 2.188 13.438 2.188 Z M 10 13.75 C 7.929 13.75 6.25 12.071 6.25 10 C 6.25 7.929 7.929 6.25 10 6.25 C 12.071 6.25 13.75 7.929 13.75 10 C 13.75 12.071 12.071 13.75 10 13.75 Z M 14.063 6.875 C 13.545 6.875 13.125 6.455 13.125 5.938 C 13.125 5.42 13.545 5 14.063 5 C 14.58 5 15 5.42 15 5.938 C 15 6.455 14.58 6.875 14.063 6.875 Z"
              fill="#000000"
            ></path>
          </svg>
        </a>
        <!-- Twitter -->
        <a href="https://twitter.com/i/flow/login" target="_blank">
          <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20">
            <path d="M 0 0 L 20 0 L 20 20 L 0 20 Z" fill="transparent"></path>
            <path
              d="M 19.195 6.07 L 16.836 8.422 C 16.367 13.883 11.758 18.125 6.25 18.125 C 5.117 18.125 4.18 17.945 3.469 17.594 C 2.898 17.305 2.664 17 2.602 16.906 C 2.497 16.747 2.47 16.549 2.53 16.368 C 2.589 16.187 2.728 16.043 2.906 15.977 C 2.922 15.969 4.766 15.266 5.961 13.914 C 5.22 13.386 4.568 12.743 4.031 12.008 C 2.961 10.555 1.828 8.031 2.508 4.266 C 2.551 4.038 2.716 3.852 2.938 3.781 C 3.16 3.709 3.404 3.766 3.57 3.93 C 3.594 3.961 6.195 6.523 9.375 7.352 L 9.375 6.875 C 9.381 5.874 9.785 4.917 10.497 4.214 C 11.209 3.51 12.171 3.119 13.172 3.125 C 14.495 3.144 15.711 3.856 16.375 5 L 18.75 5 C 19.002 4.999 19.23 5.15 19.328 5.383 C 19.42 5.618 19.368 5.886 19.195 6.07 Z"
              fill="#000000"
            ></path>
          </svg>
        </a>
      </div>
    </div>
  </div>
</template>

<style scoped>
.footer {
  box-sizing: border-box;
  flex-shrink: 0;
  width: 100%;
  height: min-content;
  display: flex;
  flex-direction: column;
  padding: 100px;
  background-color: #faa307;
  overflow: visible;
  align-content: center;
  flex-wrap: nowrap;
  gap: 60px;
  border-color: rgba(0, 0, 0, 0.05);
  border-style: solid;
  border-top-width: 1px;
}

.horizontal {
  flex-shrink: 0;
  width: 100%;
  height: min-content;
  display: flex;
  flex-direction: row;
  align-items: center;
  overflow: visible;
  align-content: flex-start;
  flex-wrap: wrap;
  gap: 40px;
}

.vertical {
  flex-shrink: 0;
  width: 30%;
  height: min-content;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: flex-start;
  overflow: visible;
  align-content: flex-start;
  flex-wrap: nowrap;
  gap: 15px;
}

.theme-header {
  flex-shrink: 0;
  width: auto; /* 29px */
  height: auto; /* 24px */
  white-space: pre;
  overflow: visible;
  font-weight: 700;
  font-style: normal;
  font-family: 'Archivo', 'Archivo Placeholder', sans-serif;
  color: #03071e;
  font-size: 16px;
  letter-spacing: -0.025em;
  line-height: 1.5;
  text-align: left;
}

.link {
  text-decoration: none;
  flex-shrink: 0;
  width: auto; /* 57px */
  height: auto; /* 24px */
  white-space: pre;
  overflow: visible;
  font-weight: 400;
  font-style: normal;
  font-family: 'Archivo', 'Archivo Placeholder', sans-serif;
  color: #000000;
  font-size: 16px;
  letter-spacing: 0em;
  line-height: 1.5;
  text-align: left;
}

.link:hover {
  color: #03071e;
  text-decoration: underline;
  cursor: pointer;
}

.copyright {
  flex-shrink: 0;
  width: 100%;
  height: min-content;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  overflow: visible;
  position: relative;
  align-content: center;
  flex-wrap: nowrap;
}

._2023-all-rights-reserved {
  flex-shrink: 0;
  width: auto;
  height: auto;
  white-space: pre;
  overflow: visible;
  font-weight: 400;
  font-style: normal;
  font-family: 'Archivo', 'Archivo Placeholder', sans-serif;
  color: #000000;
  font-size: 16px;
  letter-spacing: 0em;
  line-height: 1.5;
  text-align: left;
}

.icons {
  flex-shrink: 0;
  width: min-content;
  height: min-content;
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  align-items: center;
  overflow: visible;
  align-content: center;
  flex-wrap: nowrap;
  gap: 10px;
}

.icons:hover {
  cursor: pointer;
}

@media screen and (max-width: 1199px) and (min-width: 810px) {
  .vertical {
    width: 20%;
  }
}

/* Phone styles */
@media screen and (max-width: 809px) {
  .vertical {
    width: 100%;
    align-items: center;
  }

  .copyright {
    flex-direction: column;
  }

  .icons {
    width: 100%;
    justify-content: center;
  }
}
</style>
