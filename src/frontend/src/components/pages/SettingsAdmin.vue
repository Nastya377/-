<!--<template>
  
  <div class="container-fluid mt-4">
      <div class="col-md-7">
        <billing-card
          title="Billing Information"
          :bills="[
            {
              name: 'Oliver Liam',
              company: 'Viking Burrito',
              email: 'oliver@burrito.com',
              id: 'FRB1235476',
            },
            {
              name: 'Lucas Harper',
              company: 'Stone Tech Zone',
              email: 'lucas@stone-tech.com',
              id: 'FRB1235476',
            },
            {
              name: 'Ethan James',
              company: 'Fiber Notion',
              email: 'ethan@fiber.com',
              id: 'FRB1235476',
            },
          ]"
        />
      </div>

  </div>
</template>

<script>
import setTooltip from "@/assets/js/tooltip.js";
import BillingCard from "./smallComponents/BillingCard.vue";
export default {
  name: "SettingsAdmin",
  components: {
    BillingCard,
  },
  mounted() {
    setTooltip();
  },
};
</script>-->
<template>
  <div class="py-4 container-fluid">
    <div class="row">
      <div class="col-12">
        <authors-table />
      </div>
      <div class="col-12">
        <profession-table />
      </div>
      <div class="col-12">
        <salary-table />
      </div>
    </div>
    <!--<div class="row">
      <div class="col-12">
        <projects-table />
      </div>
    </div>-->
  </div>
</template>

<script>
import AuthorsTable from "../pages/smallComponents/AuthorsTable.vue";
import ProfessionTable from "../pages/smallComponents/ProfessionTable.vue";
import SalaryTable from "../pages/smallComponents/SalaryTable.vue";
//import ProjectsTable from "../pages/smallComponents/ProjectsTable.vue";
export default {
  name: "SettingsAdmin",
  components: {
    AuthorsTable,
    ProfessionTable,
    SalaryTable,
    //ProjectsTable,
  },
};
</script>

