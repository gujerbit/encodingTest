<template>
  <section>
    <slot name="title" />
    <article class="none">
      <p class="subject">NONE-ENCODING</p>
      <p class="content">{{none}}</p>
    </article>
    <article class="encoding">
      <p class="subject">ENCODING</p>
      <p class="content">{{encoding}}</p>
    </article>
    <article class="base64">
      <p class="subject">BASE64</p>
      <p class="content">{{base64}}</p>
    </article>        
  </section>
</template>

<script>
export default {
  setup() {
  },
  props: [
    'none',
    'encoding',
    'base64'
  ]
}
</script>

<style scoped>
@import "../css/content.css";
</style>