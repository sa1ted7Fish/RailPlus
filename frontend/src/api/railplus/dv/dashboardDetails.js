import request from '@/utils/request'

// 查询DashboardDetails列表
export function listDashboardDetails(query) {
  return request({
    url: '/dv/dashboardDetails/list',
    method: 'get',
    params: query
  })
}

// 查询DashboardDetails详细
export function getDashboardDetails(dashboardId) {
  return request({
    url: '/dv/dashboardDetails/' + dashboardId,
    method: 'get'
  })
}

// 新增DashboardDetails
export function addDashboardDetails(data) {
  return request({
    url: '/dv/dashboardDetails',
    method: 'post',
    data: data
  })
}

// 修改DashboardDetails
export function updateDashboardDetails(data) {
  return request({
    url: '/dv/dashboardDetails',
    method: 'put',
    data: data
  })
}

// 删除DashboardDetails
export function delDashboardDetails(dashboardId) {
  return request({
    url: '/dv/dashboardDetails/' + dashboardId,
    method: 'delete'
  })
}
