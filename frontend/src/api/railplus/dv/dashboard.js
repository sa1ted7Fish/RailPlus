import request from '@/utils/request'

// 查询Dashboard列表
export function listDashboard(query) {
  return request({
    url: '/dv/dashboard/list',
    method: 'get',
    params: query
  })
}

// 查询Dashboard详细
export function getDashboard(dashboardId) {
  return request({
    url: '/dv/dashboard/' + dashboardId,
    method: 'get'
  })
}

// 新增Dashboard
export function addDashboard(data) {
  return request({
    url: '/dv/dashboard',
    method: 'post',
    data: data
  })
}

// 修改Dashboard
export function updateDashboard(data) {
  return request({
    url: '/dv/dashboard',
    method: 'put',
    data: data
  })
}

// 删除Dashboard
export function delDashboard(dashboardId) {
  return request({
    url: '/dv/dashboard/' + dashboardId,
    method: 'delete'
  })
}
