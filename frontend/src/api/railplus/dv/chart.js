import request from '@/utils/request'

// 查询Chart列表
export function listChart(query) {
  return request({
    url: '/dv/chart/list',
    method: 'get',
    params: query
  })
}

// 查询Chart详细
export function getChart(chartId) {
  return request({
    url: '/dv/chart/' + chartId,
    method: 'get'
  })
}

// 新增Chart
export function addChart(data) {
  return request({
    url: '/dv/chart',
    method: 'post',
    data: data
  })
}

// 修改Chart
export function updateChart(data) {
  return request({
    url: '/dv/chart',
    method: 'put',
    data: data
  })
}

// 删除Chart
export function delChart(chartId) {
  return request({
    url: '/dv/chart/' + chartId,
    method: 'delete'
  })
}
