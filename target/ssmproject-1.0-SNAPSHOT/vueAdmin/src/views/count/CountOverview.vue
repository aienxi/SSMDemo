<template>
  <div>
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
      <div class="table-title">新语数字有声图书馆平台访问概览</div>
      <el-table
        :data="tableData"
        stripe
        style="width: 100%"
      >
        <el-table-column
          prop="sort"
          label="序号"
          width="180"
        >
        </el-table-column>
        <el-table-column
          prop="date"
          label="日期"
          width="180"
        >
        </el-table-column>
        <el-table-column
          prop="searchCount"
          label="检索量"
        >
        </el-table-column>
        <el-table-column
          prop="visitCount"
          label="浏览量"
        >
        </el-table-column>
        <el-table-column
          prop="downloadCount"
          label="下载量"
        >
        </el-table-column>
      </el-table>
      <div class="pagination">
        <el-pagination
          background
          layout="prev, pager, next"
          :page-count="56"
          @current-change="currentChange"
        >
        </el-pagination>

      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'Overview',
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
    margin: 20px;
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
