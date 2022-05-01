<template>
  <div class="card mb-4">
    <div class="card-header pb-0">
      <h6>Работники</h6>
      <div class="input-group">
       <input v-model="search" class="form-control" placeholder="Поиск">
       <button class="btn mb-0 bg-gradient-dark btn-md null null">Поиск</button>
       <button class="btn mb-0 bg-gradient-dark btn-md null null" v-on:click="$router.push('/Settings')">Добавление</button>
       <button class="btn mb-0 bg-gradient-dark btn-md null null" v-on:click="$router.push('/Settings')">Редактирование</button>
       <button class="btn mb-0 bg-gradient-dark btn-md null null">Расчитать</button>
       <button class="btn mb-0 bg-gradient-dark btn-md null null">Непроверенные</button>
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
                ФИО
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                Ник
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                Должность
              </th>
               <th
                class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"
              >
                Статус
              </th>
              <th
                class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"
              >
                Телефон
              </th>
              <th class="text-secondary opacity-7"></th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>
                <div class="d-flex px-2 py-1">
                  <div class="d-flex flex-column justify-content-center">
                    <h6 class="mb-0 text-sm">John Michael</h6>
                    <p class="text-xs text-secondary mb-0">
                      john@creative-tim.com
                    </p>
                  </div>
                </div>
              </td>
              <td>
                <p class="text-xs font-weight-bold mb-0">123</p>
              </td>
              <td>
                <p class="text-xs font-weight-bold mb-0">Manager</p>
              </td>
                <td class="align-middle text-center text-sm">
                <vsud-badge color="secondary" variant="gradient" size="sm"
                  >Непроверено</vsud-badge
                >
              </td>
              <td class="align-middle text-center">
                <span class="text-secondary text-xs font-weight-bold"
                  >23/04/18</span
                >
              </td>
            </tr>
            <tr>
              <td>
                <div class="d-flex px-2 py-1">
                  <div class="d-flex flex-column justify-content-center">
                    <h6 class="mb-0 text-sm">Alexa Liras</h6>
                    <p class="text-xs text-secondary mb-0">
                      alexa@creative-tim.com
                    </p>
                  </div>
                </div>
              </td>
              <td>
                <p class="text-xs font-weight-bold mb-0">1211</p>
              </td>
              <td>
                <p class="text-xs font-weight-bold mb-0">Programator</p>
              </td>
               <td class="align-middle text-center text-sm">
                <vsud-badge color="success" variant="gradient" size="sm"
                  >Подтверждено</vsud-badge
                >
              </td>
              <td class="align-middle text-center">
                <span class="text-secondary text-xs font-weight-bold"
                  >11/01/19</span
                >
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
import VsudBadge from "../globalComponent/VsudBadge.vue";

export default {
  name: "authors-table",
  data() {
    return {
      
    };
  },
  components: {
    //VsudAvatar,
    VsudBadge,
  },
};
</script>
