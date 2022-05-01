<template>
  <div class="card mb-4">
    <div class="card-header pb-0">
      <h6>Профессии</h6>
      <div class="input-group">
       <input v-model="search" class="form-control" placeholder="Поиск">
       <button class="btn mb-0 bg-gradient-dark btn-md null null">Поиск</button>
       <button class="btn mb-0 bg-gradient-dark btn-md null null" v-on:click="$router.push('/ProfessionsEdit')">Добавление</button>
      <button class="btn mb-0 bg-gradient-dark btn-md null null" v-on:click="$router.push('/ProfessionsEdit')">Редактирование</button>
      </div>
    </div>
    <div class="card-body px-0 pt-0 pb-2">
      <div class="table-responsive p-0">
        <table class="table align-items-center mb-0">
          <thead>
            <tr>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"
              >
                Название
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                Зарплата
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                Тип оплаты
              </th>
              <th class="text-secondary opacity-7"></th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>
                <div class="d-flex px-2 py-1">
                  <div class="d-flex flex-column justify-content-center">
                    <h6 class="mb-0 text-sm">Manager</h6>
                  </div>
                </div>
              </td>
              <td>
                <p class="text-xs font-weight-bold mb-0">70</p>
              </td>
              <td>
                <p class="text-xs font-weight-bold mb-0">70</p>
              </td>
            </tr>
            <tr>
              <td>
                <div class="d-flex px-2 py-1">
                  <div class="d-flex flex-column justify-content-center">
                    <h6 class="mb-0 text-sm">Programator</h6>
                  </div>
                </div>
              </td>
              <td>
                <p class="text-xs font-weight-bold mb-0">250</p>
              </td>
              
              <td>
                <p class="text-xs font-weight-bold mb-0">70</p>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
  
</template>

<script>
//import VsudAvatar from "../globalComponent/VsudAvatar.vue";
//import VsudBadge from "../globalComponent/VsudBadge.vue";

export default {
  name: "profession-table",
  data() {
    return {
      
    };
  },
  components: {
    //VsudAvatar,
   // VsudBadge,
  },
};
</script>
