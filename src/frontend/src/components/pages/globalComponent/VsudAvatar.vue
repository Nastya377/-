<template>
  <div class="avatar" :class="getSize(size)">
  </div>
</template>

<script>
export default {
  name: "VsudAvatar",
  props: {
    alt: {
      type: String,
      default: "",
    },
    size: {
      type: String,
      default: null,
    },
    shadow: {
      type: String,
      default: null,
    },
    borderRadius: {
      type: String,
      default: null,
    },
    circular: Boolean,
  },
  methods: {
    getSize: (size) => (size ? `avatar-${size}` : null),
    getClasses: (shadow, circular, borderRadius) => {
      let shadowValue, circularValue, borderRadiusValue;

      if (shadow) {
        shadowValue = shadow === "regular" ? "shadow" : `shadow-${shadow}`;
      } else {
        shadowValue = null;
      }

      circularValue = circular ? "rounded-circle" : null;

      borderRadiusValue = borderRadius ? `border-radius-${borderRadius}` : null;

      return `${shadowValue} ${circularValue} ${borderRadiusValue}`;
    },
  },
};
</script>
