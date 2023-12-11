import request from '@/utils/request'

// 查询API列表
export function listApi(query) {
  return request({
    url: '/dv/api/list',
    method: 'get',
    params: query
  })
}

// 查询API详细
export function getApi(apiId) {
  return request({
    url: '/dv/api/' + apiId,
    method: 'get'
  })
}

// 新增API
export function addApi(data) {
  return request({
    url: '/dv/api',
    method: 'post',
    data: data
  })
}

// 修改API
export function updateApi(data) {
  return request({
    url: '/dv/api',
    method: 'put',
    data: data
  })
}

// 删除API
export function delApi(apiId) {
  return request({
    url: '/dv/api/' + apiId,
    method: 'delete'
  })
}
