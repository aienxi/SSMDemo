<template>
  <div class="app-container">
    <div class="selectNav">
      <div class="block">
        <el-date-picker
          v-model="value2"
          type="daterange"
          align="right"
          unlink-panels
          range-separator="至"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
          :picker-options="pickerOptions"
        >
        </el-date-picker>
        <el-button class="look-button" type="primary" icon="el-icon-search">搜索</el-button>
      </div>
    </div>
    <div class="content">
      <div class="table-title">平台检索量统计</div>
      <chart height="100%" width="100%" />

    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import Chart from '@/components/Charts/MixChart'

export default {
  name: 'Overview',
  components: { Chart },
  data() {
    return {
      pickerOptions: {
        shortcuts: [{
          text: '最近一周',
          onClick(picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 7)
            picker.$emit('pick', [start, end])
          }
        }, {
          text: '最近一个月',
          onClick(picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 30)
            picker.$emit('pick', [start, end])
          }
        }, {
          text: '最近三个月',
          onClick(picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 90)
            picker.$emit('pick', [start, end])
          }
        }]
      },
      value1: '',
      value2: '',
      tableData: []

    }
  },
  computed: {
    ...mapGetters([
      'name'
    ])
  },
  created() {
    this.getData()
  },
  methods: {
    getData() {
      var arrData = []
      for (let index = 0; index < 20; index++) {
        var data = {
          sort: index + 1,
          date: '2020-10-22',
          searchCount: 100,
          visitCount: 200,
          downloadCount: 1000
        }
        arrData.push(data)
      }
      this.tableData = this.tableData.concat(arrData)
      console.log(this.tableData)
    },
    currentChange(e) {
      console.log('currentChange' + e)
      this.getData()
    }
  }
}
</script>

<style lang="scss" scoped>
.selectNav{
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    height: 60px;
    align-items: center;
}
.block{
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
    margin-left: 20px;
}
.look-button{
    margin-left: 20px;
}
.content{
    height: 500px;
    width: 100%;
}
.table-title{
    width: 100%;
    height: 80px;
    text-align: center;
    line-height: 80px;
    background: #F2F6FC;
}
.pagination{
    width: 100%;
    height: 60px;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
}
</style>
