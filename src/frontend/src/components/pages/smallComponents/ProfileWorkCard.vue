<template>
  <div class="card h-100">
    <div class="p-3 pb-0 card-header">
      <div class="row">
        <div class="col-md-8 d-flex align-items-center">
          <h6 class="mb-0">{{ title }}</h6>
        </div>
        <div class="col-md-4 text-end">
          <a :href="action.route">
            <i
              class="text-sm fas fa-user-edit text-secondary"
              data-bs-toggle="tooltip"
              data-bs-placement="top"
              :title="action.tooltip"
            ></i>
          </a>
        </div>
      </div>
    </div>
    <div class="p-3 card-body">
      <p class="text-sm">
        {{ description }}
      </p>
      <hr class="my-4 horizontal gray-light" />
      <ul class="list-group">
        <li class="pt-0 text-sm border-0 list-group-item ps-0">
          <strong class="text-dark">Должность:</strong> &nbsp;
          {{ info.position }}
        </li>
        <li class="text-sm border-0 list-group-item ps-0">
          <strong class="text-dark">Рабочий телефон:</strong> &nbsp; {{ info.telefoncomp }}
        </li>
        
        <li class="text-sm border-0 list-group-item ps-0">
          <strong class="text-dark">Место работы:</strong> &nbsp;
          {{ info.locationcom }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>

export default {
  name: "ProfileWorkCard",
  components: {  },
  props: {
    title: {
      type: String,
      default: "",
    },
    description: {
      type: String,
      default: "",
    },
    info: {
      type: Object,
      position: String,
      telefoncomp: String,
      locationcom: String,
      default: () => {},
    },
    social: {
      type: Array,
      link: String,
      icon: String,
      default: () => [],
    },
    action: {
      type: Object,
      route: String,
      tooltip: String,
      default: () => ({
        route: "javascript:;",
      }),
    },
  },
};
</script>
