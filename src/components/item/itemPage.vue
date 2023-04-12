<template>
<div class="item">
  <slot></slot>

</div>
</template>

<script>
export default {
  name: "itemPage"
}
</script>

<style lang="less">
.item{
  height:250px;
  border: 1px solid blue;
  margin: 20px;
  background-color: rgba(12,130,255,.85);
}
</style>