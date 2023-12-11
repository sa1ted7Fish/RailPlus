import request from '@/utils/request'

export const fetchGet = (url, query) => {
  return request({
    url: url,
    method: 'get',
    params: query
  })
}

export function getChart(chartName) {
  return request({
    url: '/dv/common/c?chartName=' + chartName,
    method: 'get'
  })
}

export function getDashboardPreview(dashboardId) {
  return request({
    url: '/dv/common/dp?dashboardId=' + dashboardId,
    method: 'get'
  })
}
